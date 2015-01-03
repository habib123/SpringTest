package tum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





import tum.service.StudentService;
import tum.spring.Student;
import tum.validation.studentValidation;



/**
 * @author Habibur Rahman
 */
@Controller
public class HomeController {

    protected static final String INDEX_VIEW = "index";
    protected static final String WELCOME_VIEW = "welcome";
    protected static final String LOGIN_VIEW = "login";
   protected static final String INFORMATION_VIEW = "information";
    
    @Autowired
   private StudentService studentService;
    
    @Autowired
    private studentValidation studentvalidator;
    
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(studentvalidator);
	}
	
    @RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
    public String showPage() {
        return INDEX_VIEW;
    }
    @RequestMapping(value="/information", method=RequestMethod.GET)
    public ModelAndView showPage1() {
    	 
    	return new ModelAndView(INFORMATION_VIEW);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView  welcomePage() {
    	ModelAndView mav = new ModelAndView(LOGIN_VIEW, "student", new Student());
		return mav;
    }
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Student student,
			BindingResult result, final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors())
			return new ModelAndView(LOGIN_VIEW);
		
		studentService.create(student);
		ModelAndView mav = new ModelAndView();
		
		redirectAttributes.addFlashAttribute("message", "hi");
		List<Student> studentList = studentService.findAll();
		mav.addObject("studentList", studentService.findAll() );
		//mav.addObject("info", INFORMATION_VIEW);
	  	mav.setViewName(INFORMATION_VIEW);
		return mav;	
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable Integer id) {
			
		ModelAndView mav = new ModelAndView("studentedit");
		
		Student student = studentService.findById(id);
		mav.addObject("student", student);
		return mav;
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student, BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) {
			
		if(result.hasErrors())
			return new ModelAndView("studentedit");
		studentService.update(student);
		
		ModelAndView mav = new ModelAndView("information");
		
		mav.addObject("studentList", studentService.findAll() );
	
		return mav;
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView editDelete(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
			
		ModelAndView mav = new ModelAndView("information");
		
		 studentService.delete(id);
		mav.addObject("studentList", studentService.findAll() );
		
		String message = "The student was successfully deleted.";
		
		
		redirectAttributes.addFlashAttribute("message", message);
		
		return mav;
	}
	@RequestMapping(value="/name", method=RequestMethod.GET)
	public ModelAndView findByName(RedirectAttributes redirectAttributes) {
			
		ModelAndView mav = new ModelAndView("informationbyname");
		
		List<Student> studentList =  studentService.findByName("habib");
		mav.addObject("studentList", studentList);
		
		String message = "The student was successfully deleted.";
		
		
		redirectAttributes.addFlashAttribute("message", message);
		
		return mav;
	}
	
	
    
    
}
