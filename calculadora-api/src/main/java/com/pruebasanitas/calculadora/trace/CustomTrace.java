package com.pruebasanitas.calculadora.trace;

import org.springframework.stereotype.Component;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

@Component
public class CustomTrace extends TracerImpl implements TracerAPI{

}
