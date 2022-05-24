package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.PreparedStatement;

import candidat.Candidat;
import dao.CandidatDao;
import dao.CandidatImp;
import dao.UtilisateurDAO;
import dao.UtilisateurImp;
import utilisateur.Utilisateur;

public class ServletGlobal extends HttpServlet{
	private UtilisateurDAO metier;
	private CandidatDao metier2;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		metier = new UtilisateurImp();
		metier2 = new CandidatImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		if(path.equals("/accueil.do")) {
			req.getRequestDispatcher("accueil.jsp").forward(req, resp);
		}

		else if(path.equals("/inscrire.do")) {
			req.getRequestDispatcher("inscrire.jsp").forward(req, resp);
		}
		
		else if(path.equals("/inscription.do") && (req.getMethod().equals("POST"))) {
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String adresse = req.getParameter("adresse");
			int numero = Integer.parseInt(req.getParameter("numero"));
			String password = req.getParameter("password");
			int cin = Integer.parseInt(req.getParameter("cin"));
			metier.save(new Utilisateur(nom,prenom,adresse,numero,password,cin));
//			HttpSession session = req.getSession();
//			session.setAttribute("nom", nom);
//			session.setAttribute("prenom", prenom);
			resp.sendRedirect("connexion.jsp");
		}
		
		else if(path.equals("/connexion.do")) {
			req.getRequestDispatcher("connexion.jsp").forward(req, resp);
		}
		
		else if(path.equals("/login.do") && (req.getMethod().equals("POST"))) {
			String nom = req.getParameter("nom");
	        String password = req.getParameter("password");
	        
	        try{
	            Connection con;
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting_system", "root","");
	            
	            String sql = "select * from utilisateur where nom=? and password=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	            
	            ps.setString(1, nom);
	            ps.setString(2, password);
	            
	            String nomBD = "";
	            String passwordBD = "";
	            int id;
	            int id_candidat;
	            
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()){
	            	nomBD = rs.getString("nom");
	            	passwordBD = rs.getString("password");
	            	id = rs.getInt("id_utilisateur");
	            	id_candidat = rs.getInt("id_candidat");
	                HttpSession session = req.getSession();   
	                session.setAttribute("id_utilisateur", id);
	                session.setAttribute("id_candidat", id_candidat);
	            }
	            
	            if(nom.equals(nomBD) && password.equals(passwordBD)){
	                HttpSession session = req.getSession();    
	                session.setAttribute("nom", nom);
//	                session.setAttribute("password", password);
	                resp.sendRedirect("candidat.do");
	                
	            }else{
	            	String error = "email ou mot de passe incorrect";
	            	req.setAttribute("error", error);
	            	System.out.println(error);
//	                resp.sendRedirect("connexion.jsp");
	    			req.getRequestDispatcher("connexion.jsp").forward(req, resp);
	            }
	        }
	        
	        catch(Exception e) {
	            System.out.println("error" + e.getMessage());
	        }
	        
		}
		
		else if(path.equals("/reconnecter.do") && (req.getMethod().equals("POST"))) {
			String nom = req.getParameter("nom");
	        String password = req.getParameter("password");
	        
	        try{
	            Connection con;
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting_system", "root","");
	            
	            String sql = "select * from utilisateur where nom=? and password=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	            
	            ps.setString(1, nom);
	            ps.setString(2, password);
	            
	            String nomBD = "";
	            String passwordBD = "";
	            int id;
	            int id_candidat;
	            
	            ResultSet rs = ps.executeQuery();

	            while(rs.next()){
	            	nomBD = rs.getString("nom");
	            	passwordBD = rs.getString("password");
	            	id = rs.getInt("id_utilisateur");
	            	id_candidat = rs.getInt("id_candidat");
	                HttpSession session = req.getSession();   
	                session.setAttribute("id_utilisateur", id);
	                session.setAttribute("id_candidat", id_candidat);
	            }
	            
	            if(nom.equals(nomBD) && password.equals(passwordBD)){
	                HttpSession session = req.getSession();    
	                session.setAttribute("nom", nom);
//	                session.setAttribute("password", password);
	                resp.sendRedirect("candidat.do");
	                
	            }else{
	            	String error = "email ou mot de passe incorrect";
	            	req.setAttribute("error", error);
	            	System.out.println(error);
//	                resp.sendRedirect("connexion.jsp");
//	    			req.getRequestDispatcher("connexion.jsp").forward(req, resp);
	            }
	        }
	        
	        catch(Exception e) {
	            System.out.println("error" + e.getMessage());
	        }
	        
		}
		
		else if(path.equals("/deconnexion.do")) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("accueil.jsp");
		}
		
		else if(path.equals("/candidat.do")) {
			List<Candidat> candidat = metier2.listeCandidat();
			req.setAttribute("candidats", candidat);
			req.getRequestDispatcher("candidat.jsp").forward(req, resp);
		}
		
		else if(path.equals("/detailcandidat.do")) {
			Long id_candidat = Long.parseLong(req.getParameter("id"));
			Candidat c = metier2.getCandidat(id_candidat);
			Candidat c2 = metier2.countCandidat(id_candidat);
			
			req.setAttribute("count", c2);
			req.setAttribute("id_candidat", id_candidat);
			req.setAttribute("candidat", c);
			req.getRequestDispatcher("detailcandidat.jsp").forward(req, resp);
		}
		
		else if(path.equals("/voter.do")) {
			int id_candidat = Integer.parseInt(req.getParameter("id_candidat"));
			int id_utilisateur = Integer.parseInt(req.getParameter("id_utilisateur"));
			
			try{
	            Connection con;
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting_system", "root","");
	            
	            String sql = "UPDATE utilisateur SET id_candidat = ? WHERE id_utilisateur = ?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	            
	            ps.setInt(1, id_candidat);
	            ps.setInt(2, id_utilisateur);
	            
	            ps.executeUpdate();
	            
	            // redemander
	            HttpSession session = req.getSession();
				session.invalidate();
				resp.sendRedirect("reponse.jsp");
	        }
	        
	        catch(Exception e) {
	            System.out.println("error" + e.getMessage());
	        }
		
//			resp.sendRedirect("candidat.do");
		}
		
		else if(path.equals("/administration.do")) {
			List<Candidat> candidat = metier2.listeCandidat();
			req.setAttribute("candidats", candidat);
			req.getRequestDispatcher("administration.jsp").forward(req, resp);
		}
		
		else if(path.equals("/ajoutcandidat.do") && (req.getMethod().equals("POST"))) {
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String email = req.getParameter("email");
			String adresse = req.getParameter("adresse");
			int numero = Integer.parseInt(req.getParameter("numero"));
			int cin = Integer.parseInt(req.getParameter("cin"));
			
			metier2.save(new Candidat(nom,prenom,email,adresse,numero,cin));
			req.getRequestDispatcher("administration.do").forward(req, resp);
		}
		
		else if(path.equals("/supprimercandidat.do")) {
			Long id = Long.parseLong(req.getParameter("id"));
			metier2.deleteCandidat(id);
			resp.sendRedirect("administration.do");
		}
		
		else if(path.equals("/modifiercandidat.do")) {
			Long id = Long.parseLong(req.getParameter("id"));
			Candidat c = metier2.getCandidat(id);
			req.setAttribute("candidat", c);
			req.getRequestDispatcher("modifiercandidat.jsp").forward(req, resp);
		}
		
		else if(path.equals("/updatecandidat.do") && (req.getMethod().equals("POST"))) {
			Long id = Long.parseLong(req.getParameter("id"));
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String email = req.getParameter("email");
			String adresse = req.getParameter("adresse");
			int numero = Integer.parseInt(req.getParameter("numero"));
			int cin = Integer.parseInt(req.getParameter("cin"));
			
			Candidat c = new Candidat(nom,prenom,email,adresse,numero,cin);
			c.setId_candidat(id);
			metier2.UpdateCandidat(c);
			req.getRequestDispatcher("administration.do").forward(req, resp);
		}
		else if(path.equals("/count.do")) {
			req.getRequestDispatcher("count.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
