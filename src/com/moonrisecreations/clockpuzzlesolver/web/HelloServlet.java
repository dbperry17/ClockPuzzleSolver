package com.moonrisecreations.clockpuzzlesolver.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
        String[] clockStr = request.getParameterValues("jsArray");
        System.out.println("Test: " + clockStr);
        ArrayList<Integer> clockNums = formatInput(clockStr);
        Clock clock = new Clock(clockNums);
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello, and welcome to the Clock Puzzle Solver. Your numbers are: " + clock.getNodeList()
                + "</h1>");
        writer.close();
    }

    private ArrayList<Integer> formatInput(String[] strArr)
    {
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        if (strArr == null)
            System.out.println("Didn't work");
        else
        {
            for (String str : strArr)
                intArr.add(Integer.parseInt(str));
        }

        return intArr;
    }

}
