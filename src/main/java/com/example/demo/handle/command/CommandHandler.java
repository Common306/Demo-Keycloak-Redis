package com.example.demo.handle.command;

import com.example.demo.dto.request.command.CommandRequestData;
import com.example.demo.dto.response.command.CommandResponseData;
import com.example.demo.handle.IHandler;

public abstract class CommandHandler<T extends CommandRequestData, I extends CommandResponseData> implements IHandler<T, I> {

}
