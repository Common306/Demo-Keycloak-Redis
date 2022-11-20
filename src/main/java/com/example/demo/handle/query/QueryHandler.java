package com.example.demo.handle.query;

import com.example.demo.dto.request.query.QueryRequestData;
import com.example.demo.dto.response.query.QueryResponseData;
import com.example.demo.handle.IHandler;

public abstract class QueryHandler<T extends QueryRequestData, I extends QueryResponseData> implements IHandler<T, I> {
}
