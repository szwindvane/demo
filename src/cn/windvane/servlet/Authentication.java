package cn.windvane.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import cn.windvane.bean.Result;
import cn.windvane.util.HttpRequestUtil;
import cn.windvane.util.MysqlUtil;

/**
 * Servlet implementation class Authentication
 */
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Authentication.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String resultMsg;
		if(password.equals("error")){
			resultMsg = JSON.toJSONString(new Result("user does is not exit",1));
			logger.error(resultMsg);
		}
		else if (password.equals("slow")){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultMsg = JSON.toJSONString(new Result("login success",0));
			logger.info(resultMsg);
		}
		else if(password.equals("mysql")){
			MysqlUtil.connectMysql();
			resultMsg = JSON.toJSONString(new Result("login success",0));
			logger.info(resultMsg);
		}
		else if(password.equals("http")){
			HttpRequestUtil.doGet("http://www.baidu.com");
			resultMsg = JSON.toJSONString(new Result("login success",0));
			logger.info(resultMsg);
		}
		else if (password.equals("httperror")){
			HttpRequestUtil.doGet("http://www.baidu1.com");
			resultMsg = JSON.toJSONString(new Result("login success",0));
			logger.info(resultMsg);
		}
		else{
			resultMsg = JSON.toJSONString(new Result("login success",0));
			logger.info(resultMsg);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(resultMsg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
