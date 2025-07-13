package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/seasonurl")
public class SeasonFinderServlet extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SeasonFinderServlet.doGet()");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		LocalDateTime ldt=LocalDateTime.now();
		int month=ldt.getMonthValue();
		String seasonName=null;
		if(month>=3 && month<=6)
		{
			seasonName="Summer Season";
		}
		else if(month>=7 && month<=10)
		{
			seasonName="Rainy Season";
		}
		else
		{
			seasonName="Winter Season";
		}
		
		pw.println("<h1 style='color:maroon;text-align:center;'>"+seasonName+"</h1>");
		pw.println("<a href='index.jsp'>home<img src='images/home.png' width='50' height='50'></a>");
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("SeasonFinderServlet.doPost()");
		doGet(req,res);
	}
}
