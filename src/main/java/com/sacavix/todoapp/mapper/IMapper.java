package com.sacavix.todoapp.mapper;

/**
 * Allows you to map an object and transform it to another object.
 * @param <I> input object
 * @param <O> output object
 */
public interface IMapper <I, O>{
    public O map(I in);
}
