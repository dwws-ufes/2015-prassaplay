package br.ufes.inf.nemo.prassaplay.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufes.inf.nemo.prassaplay.domain.Review;
import br.ufes.inf.nemo.prassaplay.persistence.ReviewDAO;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

@WebServlet(urlPatterns = { "/data/reviews" })
public class ListPackagesInRdfServlet extends HttpServlet {
	@EJB
	private ReviewDAO reviewDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/xml");
		List<Review> reviews = reviewDAO.recuperaTodos();
		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/PrassaPlay/data/reviews/";
		String grNS = "http://purl.org/goodrelations/v1#";
		model.setNsPrefix("gr", grNS);
		for (Review review : reviews) {
			Resource grOffering = ResourceFactory.createResource(grNS
					+ "Offering");
			Property grUsuario = ResourceFactory.createProperty(grNS
					+ "usuario");
			Property grJogo = ResourceFactory.createProperty(grNS + "jogo");
			Property grNota = ResourceFactory.createProperty(grNS + "nota");
			Property grTexto = ResourceFactory.createProperty(grNS + "texto");
			model.createResource(myNS + review.getId())
					.addProperty(RDF.type, grOffering)
					.addProperty(RDFS.label, review.getJogo().getNome())
					.addProperty(RDFS.comment, review.getTexto())
					.addProperty(grNota, review.getNota().toString())
					.addProperty(
							grUsuario,
							review.getUsuario().getNome()
									+ review.getUsuario().getId());
		}
		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
}