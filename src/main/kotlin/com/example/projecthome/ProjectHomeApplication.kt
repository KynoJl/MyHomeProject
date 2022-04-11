package com.example.projecthome

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjectHomeApplication

fun main(args: Array<String>) {
    runApplication<ProjectHomeApplication>(*args)
    println("Hello")
}
