package net.codeJava;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;






@Controller
public class MainController {

	@Autowired
    public WriterRepository writerRepository;
	@Autowired
    public BookRepository bookRepository;
	  @GetMapping("/createWriter")
	  public String showForm(Model model)
	  {
		  Writer writer = new Writer();
		  model.addAttribute("writer",writer);
		  return "createWriter";
	  }

	@PostMapping("/createWriter")
	public String createWriter(Writer writer) 
	{	    
		writerRepository.insert(writer);
		return "writerCreated";
		//return "Writer Created "+writer.getFullName();
	}

	//	  @GetMapping("/findAllBooks/{id}")
//	  public Optional<Book> getBook(@PathVariable int id)
//	  {
//		 return repository.findById(id); 
//	  }
	@GetMapping(value="/allWriters")
	public String getAllWriters(Model model)
	{
		model.addAttribute("writers",writerRepository.findAll());
		return "listWriters";
	}
	
	
	
	@GetMapping(value="/allWriters/{id}")
	public String findWriter(@PathVariable long id,Model model)//@PathVariable long id 
	{
		Optional<Writer> wr = writerRepository.findById(id);
		Writer writer = wr.get();
		model.addAttribute("writer", writer);
        //Optional<Writer> wanted = writerRepository.findById(id);
		//model.addAttribute("wanted",writerRepository.findById(id));
		return "findSingleWriter";
	}

	 @GetMapping("/deleteWriter/{id}")
	  public String deleteWriter(@PathVariable long id)
	  {
		 writerRepository.deleteById(id);
		 return "writerDeleted";
	  }
	 
	  @GetMapping("/updateWriter/{id}")
	  public String updateForm(@PathVariable long id,Model model)
	  {
			Optional<Writer> wr = writerRepository.findById(id);
			Writer writer = wr.get();
			model.addAttribute("writer", writer);
			
		  return "updateWriter";
	  }
      @PostMapping("/updateWriter")
      public String proceedUpdating(Writer writer)
      {
    	  long id = writer.getId();
    	  Optional<Writer> writer2 = writerRepository.findById(id);
    	  Writer wr2 = writer2.get();
    	  writerRepository.delete(wr2);
    	  writerRepository.insert(writer);
    	  return "writerUpdated";
      }
	  @GetMapping("/writerEntrance")
	  public String writerEntranceForm(Model model)
	  {
		  Writer writer = new Writer();
		  model.addAttribute("writer",writer);
		  return "writerEntrance";
	  }
	  
      @PostMapping("/writerEntrance")
      public String writerHome(Writer writer,Model model)
      {
    	  List<Writer> wri =  writerRepository.checkForWriter(writer.getFullName(),writer.getPassword());
    	  int count = wri.size();
    	  if(count==1)
    	  { 
    		 Writer writ = wri.get(0);
    		 model.addAttribute("writ", writ);
    		 //globalId=writ.getId();
    		 
       		 return "writerHome";
    	  }
    	  else   return "writerEntrance";
      }
      
      @GetMapping("/addBook")
      public String addBook(Model model,Book book)
      {
    	  model.addAttribute("book", book);
    	  bookRepository.save(book);
    	  
    	  return "addBook";
      }
      
    	 



}
