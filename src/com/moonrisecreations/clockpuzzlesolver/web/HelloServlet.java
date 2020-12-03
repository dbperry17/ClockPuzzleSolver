package com.moonrisecreations.clockpuzzlesolver.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moonrisecreations.clockpuzzlesolver.pojos.Clock;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String clockNums = request.getParameter("clockNums");
        Clock clock = new Clock((Integer[]) formatInput(clockNums));
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello, and welcome to the Clock Puzzle Solver. Your numbers are: " + clockNums + "</h1>");
        writer.close();
    }

    private Integer[] formatInput(String str)
    {
        StringBuilder formatted = new StringBuilder(str);

        int[] intArr = Arrays.stream((formatted.toString()).split(" ")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(intArr).boxed().toArray(Integer[]::new);
    }

}
