package com.example.demo.handle;

import com.example.demo.dto.request.command.CommandRequestData;
import com.example.demo.dto.request.query.QueryRequestData;
import com.example.demo.handle.command.CommandHandler;
import com.example.demo.handle.query.QueryHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

@Component
public class ManageHandler {

    public static Map<Class<? extends CommandRequestData>, CommandHandler> getCommandHandlerMap(ApplicationContext context) throws ClassNotFoundException {
        Map<Class<? extends CommandRequestData>, CommandHandler> mapCommandHandler = new HashMap<>();

        Map<String, CommandHandler> listCommand = context.getBeansOfType(CommandHandler.class);

        listCommand.forEach((k,v) -> {
            if(!v.getClass().getName().equals(CommandHandler.class.getName())) {
                String classRequestName = ((ParameterizedType)v.getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0].getTypeName();

                Class requestCommand = null;

                try {
                    requestCommand = Class.forName(classRequestName);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                if (CommandRequestData.class.isAssignableFrom(requestCommand)) {
                    mapCommandHandler.put(requestCommand, v);
                }
            }
        });
        return mapCommandHandler;
    }

    public static Map<Class<? extends QueryRequestData>, QueryHandler> getQueryHandlerMap(ApplicationContext context) throws ClassNotFoundException {

        Map<Class<? extends QueryRequestData>, QueryHandler> mapQueryHandler = new HashMap<>();

        Map<String, QueryHandler> listQuery = context.getBeansOfType(QueryHandler.class);

        listQuery.forEach((k, v) -> {
            if(!v.getClass().getName().equals(QueryHandler.class.getName())) {
                String classRequestName = ((ParameterizedType)v.getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0].getTypeName();;

                Class requestQuery = null;
                try {
                    requestQuery = Class.forName(classRequestName);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                if (QueryRequestData.class.isAssignableFrom(requestQuery)) {
                    mapQueryHandler.put(requestQuery, v);
                }
            }
        });
        return mapQueryHandler;
    }
}
