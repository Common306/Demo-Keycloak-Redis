package com.example.demo.service.command.popupbutton;

import com.example.demo.entities.PopupButton;
import com.example.demo.repository.command.PopupButtonCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PopupButtonCommandServiceImpl implements PopupButtonCommandService{

    private final PopupButtonCommandRepository popupButtonCommandRepository;

    @Override
    public void createPopupButton(PopupButton popupButton) {
        popupButtonCommandRepository.save(popupButton);
    }
}
