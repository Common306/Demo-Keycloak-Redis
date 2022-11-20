package com.example.demo.handle;

import com.example.demo.dto.request.RequestData;
import com.example.demo.dto.request.command.CommandRequestData;
import com.example.demo.dto.request.query.QueryRequestData;
import com.example.demo.dto.response.ResponseData;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.handle.query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Registry<T extends RequestData, I extends ResponseData>{

    @Autowired
    ApplicationContext context;
    Map<Class<? extends CommandRequestData>, CommandHandler> COMMAND_HANDLER_MAP = new HashMap<>();
    Map<Class<? extends QueryRequestData>, QueryHandler> QUERY_HANDLER_MAP = new HashMap<>();

    @PostConstruct
    public void initial() throws ClassNotFoundException {
        COMMAND_HANDLER_MAP = ManageHandler.getCommandHandlerMap(context);
        QUERY_HANDLER_MAP = ManageHandler.getQueryHandlerMap(context);
    }

    public IHandler getHandler(T requestData) {
        if(requestData instanceof  CommandRequestData) {
            for (Class<? extends CommandRequestData> commandRequest: COMMAND_HANDLER_MAP.keySet()) {
                if(requestData.getClass().getName().equals(commandRequest.getName())) {
                    return COMMAND_HANDLER_MAP.get(commandRequest);
                }
            }
        }
        else if(requestData instanceof QueryRequestData) {
            for (Class<? extends QueryRequestData> queryRequest: QUERY_HANDLER_MAP.keySet()) {
                if(requestData.getClass().getName().equals(queryRequest.getName())) {
                    return QUERY_HANDLER_MAP.get(queryRequest);
                }
            }
        }


//        if(requestData instanceof  CommandRequestData) {
//            COMMAND_HANDLER_MAP.forEach((k,v) -> {
//                if(k.getName().equals(requestData.getClass().getName())) {
//                    return v;
//                }
//            });
//        } else if(requestData instanceof RequestData) {
//            QUERY_HANDLER_MAP.forEach((k,v) -> {
//                if(k.getName().equals(requestData.getClass().getName())) {
//                    return v;
//                }
//            });
//        }


        return null;
    };


}
