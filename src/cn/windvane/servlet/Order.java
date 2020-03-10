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

/**
 * Servlet implementation class Order
 */
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Order.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String id = request.getParameter("id");
		String goodsname = request.getParameter("goodsname");
		String  price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String amount = request.getParameter("amount");
		
		String url = "http://localhost:9090/demo/PlaceOrder?username="+username+"&password="+password+"&id="+id+"&goodsname="+goodsname+"&price="+price+"&quantity="+quantity+"&amount="+amount;
		String resultMsg = HttpRequestUtil.doGet(url);
		
		Result result = JSON.parseObject(resultMsg,Result.class);
		if(result.getErrorCode() == 0){
			resultMsg = JSON.toJSONString(new Result("order success",0));
			logger.info(resultMsg);
		}else{
			resultMsg = JSON.toJSONString(new Result("order faild",1));
			logger.error(resultMsg);
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
