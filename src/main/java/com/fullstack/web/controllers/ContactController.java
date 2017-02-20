package com.fullstack.web.controllers;

import com.fullstack.web.domain.frontend.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by akjonca on 2/19/17.
 */
@Controller
public class ContactController {
    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    public static final String FEEDBACK_MODEL_KEY = "feedback";
    public static final String CONTACT_US_VIEW_NAME = "contact/contact";

  @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactGet(ModelMap model) {
      Feedback feedback = new Feedback();
      model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedback);
      return ContactController.CONTACT_US_VIEW_NAME;
  }

  @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) Feedback feedback) {
        LOG.debug("Feedback content {}", feedback);
//        emailService.sendFeedbackEmail(feedback);
        return ContactController.CONTACT_US_VIEW_NAME;
  }
}
