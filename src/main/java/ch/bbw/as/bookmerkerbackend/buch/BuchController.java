package ch.bbw.as.bookmerkerbackend.buch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BuchController {
	@Autowired
    private BuchRepository buchRepository;

    public BuchController(BuchRepository buchRepository) {
        this.buchRepository = buchRepository;
    }
}
