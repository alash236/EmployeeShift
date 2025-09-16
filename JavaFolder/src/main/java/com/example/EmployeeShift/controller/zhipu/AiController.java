package com.example.EmployeeShift.controller.zhipu;

import org.springframework.ai.image.Image;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AiController {
    private final ImageModel imageModel;

    AiController(@Qualifier("zhiPuAiImageModel")ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping("/image")
    public String image(String prompt) {
        ImageResponse response = imageModel.call(new ImagePrompt(prompt));
        Image image = response.getResult().getOutput();
        return String.format("<img src='%s' alt='%s'>", image.getUrl(), prompt);
    }


}
