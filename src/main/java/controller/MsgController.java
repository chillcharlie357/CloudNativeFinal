package controller;


import entity.MsgEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MsgService;

@RestController
@RequestMapping("/")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @GetMapping("/")
    public MsgEntity getMsg(){
            return msgService.msgEntity();
    }
}
