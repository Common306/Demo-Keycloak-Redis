package com.example.demo.dto.request.command.popup;

import com.example.demo.dto.request.command.CommandRequestData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletePopupCommandRequestData extends CommandRequestData {
    private int idDelete;

    private String langDelete;
}
