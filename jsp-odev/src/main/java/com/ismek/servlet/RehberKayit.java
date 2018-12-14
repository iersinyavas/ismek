package com.ismek.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.ismek.pojo.Rehber;

@WebServlet("/rehberKayit")
public class RehberKayit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public RehberKayit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String metod = request.getParameter("metod");
		switch (metod) {
		case "SIL":
			sil(request, response);
			break;
		case "DUZENLE":
			duzenle(request, response);
			break;
		case "GUNCELLE":
			guncelle(request, response);
			break;
		case "EKLE":
			ekle(request, response);
			break;
		default:
			break;
		}

	}
	
	private void ekle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			guncelle(request, response);
		} catch (Exception e) {
			String isim = request.getParameter("isim");
			String telefon = request.getParameter("telefon");
			Rehber rehber = new Rehber(++Rehber.sayac, isim, telefon);
			Rehber.rehberListesi.add(rehber);
			request.setAttribute("rehberListesi", Rehber.rehberListesi);
			request.getRequestDispatcher("kayit.jsp").forward(request, response);
		}	
	}

	private void sil(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		for (Rehber rehber : Rehber.rehberListesi) {
			if (rehber.getId() == id) {
				Rehber.rehberListesi.remove(rehber);
				System.out.println("silinenin id si:"+rehber.getId());
			}
		}

//		Gson gson = new Gson();
//		String gsonVeri = gson.toJson(rehberListesi);
//		System.out.println(gsonVeri);
//		response.getWriter().write(gsonVeri);
		//response.sendRedirect("kayit.jsp");
		
		request.setAttribute("rehberListesi", Rehber.rehberListesi);
		request.getRequestDispatcher("sil.jsp").forward(request, response);
	}

	private void duzenle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		for (Rehber rehber : Rehber.rehberListesi) {
			if (rehber.getId() == id) {
				Gson gson = new Gson();
				String gsonVeri = gson.toJson(rehber);
				System.out.println(gsonVeri);
				response.getWriter().write(gsonVeri);
				break;
			}
		}
	}
	
	private void guncelle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String isim = request.getParameter("isim");
		String telefon = request.getParameter("telefon");
		int sayac=0;
		for (Rehber rehber : Rehber.rehberListesi) {
			if (rehber.getId() == id) {
				rehber.setIndex(sayac);
				rehber.setIsim(isim);
				rehber.setTelefon(telefon);
//				Gson gson = new Gson();
//				String gsonVeri = gson.toJson(rehber);
//				System.out.println(gsonVeri);
//				response.getWriter().write(gsonVeri);
				break;
			}
			sayac++;
		}
		request.setAttribute("rehberListesi", Rehber.rehberListesi);
		request.getRequestDispatcher("guncelle.jsp").forward(request, response);
	}
}
