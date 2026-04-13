package com.kunkun.springwebone.entity;

import com.kunkun.springwebone.enumeration.StatusCode;
import lombok.Data;

/**
 * 我们为什么要把它变成T，因为我们可能携带一些数据，比如所有员工信息，不只是result.code
 * @param <T> 要携带的信息
 */
@Data
public class Result<T> {
    // 状态码
    private StatusCode status;
    // 要携带的信息，比如所有员工列表
    private T data;

    public Result(){}
    public Result(StatusCode status)
    {
        this.status = status;
    }

    public static <T> Result<T> success(T data)
    {
        Result<T> r = new Result<>();
        r.data = data;
        r.status = StatusCode.SUCCESS;
        return r;
    }

    public static <T> Result<T> error(StatusCode status)
    {
        Result<T> r = new Result<>();
        r.status = status;
        return r;
    }
}
