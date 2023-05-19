package org.oaoc.cookology.QNA.controller;



import org.oaoc.cookology.FAQ.model.vo.FAQ;
import org.oaoc.cookology.QNA.model.service.QNAService;
import org.oaoc.cookology.QNA.model.vo.QNA;
import org.oaoc.cookology.users.model.service.UsersService;
import org.oaoc.cookology.users.model.vo.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class QNAController {

    private static final Logger logger = LoggerFactory.getLogger(QNAController.class);
    @Autowired
    QNAService QNAService;

    @Autowired
    private UsersService usersService;




    @RequestMapping("QNAPage.do")
    public String moveQNAPage(@RequestParam("user_email") String user_email, Model model) {
//        user_email = "admin@example.com";
        logger.info("user_email : " + user_email);


        try { //로그인 한 경우
            Users users = usersService.selectUsers(user_email);
            if (users.getIs_admin().equals("Y")) {
                logger.info("QNA forwarded");
                ArrayList<QNA> admin_list = QNAService.selectNewQuestionList();
                try { //QNA가 있을 경우
                    model.addAttribute("list", admin_list);
                    return "userService/QNAPage";
                } catch (Exception e) { //QNA가 없을 경우
                    model.addAttribute("list", "");
                    return "userService/QNAPage";
                }
            } else { //관리자가 아닌 경우
                ArrayList<QNA> user_list = QNAService.selectMyQNAList(user_email);
                try { //QNA가 있을 경우
                    model.addAttribute("list", user_list);
                    return "userService/QNAPage";
                } catch (Exception e) { //QNA가 없을 경우
                    alert("로그인후 이용해주세요!");
                    return "userService/QNAPage";
                }
            }
        } catch (Exception e) { //로그인 안한 경우
            model.addAttribute("message", "로그인이 필요한 서비스 입니다!.");
            model.addAttribute("alert", true);
            return "users/loginPage";
        }

    }

    private void alert(String s) {
    }

    @RequestMapping("QNAAdminPage.do")
    public String moveAdminQNAPage(
            @RequestParam("qna_seq_id") int qna_seq_id, Model model) {

        QNA qna = QNAService.selectQNA(qna_seq_id);

        if (qna != null) {
            model.addAttribute("qna", qna);
            return "userService/QNAAdminPage";
        } else {
            model.addAttribute("message", "QNA전달안됨");
            return "common/error";
        }

    }
    // QNA UPDATESET
    @RequestMapping(value = "QNAadminUpdate.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String upDateQnaMethod(@ModelAttribute QNA qna, Model model) {
        int updateSet = QNAService.updateQNA(qna);
        String user_email = qna.getUser_email();
        if (updateSet > 0) {
            logger.info("QNA 수정 성공");
            return "QNAPage.do";

        } else {
            model.addAttribute("message", (qna.getQna_seq_id() + 1) + "번 글의 수정이 실패");
            return "common/error";
        }
    }

    /*@RequestMapping("QuestionPage.do")
    public String moveQuestionPage(Model model) {


        return "userService/QuestionPage";

    }
    // QNA UPDATESET
    @RequestMapping(value = "QNAadminUpdate.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String upDateQnaMethod(@ModelAttribute QNA qna, Model model) {
        int updateSet =  QNAService.updateQNA(qna);
        String user_email = qna.getUser_email();
        if (updateSet > 0) {
            logger.info("QNA 수정 성공");
            return "redirect:QNAPage.do?user_email="+user_email;

        } else {
            model.addAttribute("message", (qna.getQna_seq_id()+1) + "번 글의 수정이 실패");
            return "common/error";
        }
    }*/
@RequestMapping("Qinsert.do")
    public String insertQNA(
            QNA qna, Model model) {


        int result = QNAService.insertQNA(qna);

        if (result > 0) {
            logger.info("QNA 등록 성공");
            return "QNAPage.do";
        } else {
            model.addAttribute("message", "QNA 등록 실패");
            return "common/error";
        }
    }



    @RequestMapping("QuestionPage.do")
    public String moveQuestionPage(
            @RequestParam(value = "user_email") String user_email, Model model) {
        try {
            model.addAttribute("user_email", user_email);
            return "userService/QuestionPage";
        } catch (Exception e) {
            return "users/loginPage";


        }


    }

}//controller