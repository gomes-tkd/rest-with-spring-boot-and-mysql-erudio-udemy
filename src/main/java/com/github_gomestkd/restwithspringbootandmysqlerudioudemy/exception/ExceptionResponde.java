package com.github_gomestkd.restwithspringbootandmysqlerudioudemy.exception;

import java.util.Date;

public record ExceptionResponde(Date timestamp, String message, String details) {

}
