package com.example;

import com.example.models.Student;
import com.example.dao.studentDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private studentDAO studentDao = new studentDAO();
    private List<Student> studentList = studentDao.selectAllStudents();
    // private int nextId = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            studentList.removeIf(student -> student.getId() == id);
        }

        request.setAttribute("students", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            Student student = new Student(name, email, new Date());
            studentList.add(student);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            for (Student student : studentList) {
                if (student.getId() == id) {
                    student.setName(name);
                    student.setEmail(email);
                }
            }
        }

        doGet(request, response);
    }
}