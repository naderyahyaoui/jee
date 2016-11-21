package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import locator.ServiceLocator;
import server.GestionTauxDeChangeRemote;
import Domaine.TauxDeChange;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;

public class GestionTauxDeChange extends JFrame {

	private JPanel contentPane;
    List<TauxDeChange> tauxDeChanges;
    TauxDeChange tauxDeChangeSelected = new TauxDeChange();
    GestionTauxDeChangeRemote remote;
    private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionTauxDeChange frame = new GestionTauxDeChange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionTauxDeChange() {
		setVisible(true);
		remote=(GestionTauxDeChangeRemote) ServiceLocator.getInstance().getProxy("/bankServer/GestionTauxDeChange!server.GestionTauxDeChangeRemote");
		tauxDeChanges=remote.findAllTauxDeChange();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<TauxDeChange, List<TauxDeChange>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, tauxDeChanges, table);
		//
		BeanProperty<TauxDeChange, String> tauxDeChangeBeanProperty = BeanProperty.create("currency");
		jTableBinding.addColumnBinding(tauxDeChangeBeanProperty).setColumnName("Currency");
		//
		BeanProperty<TauxDeChange, Double> tauxDeChangeBeanProperty_1 = BeanProperty.create("coutAcheteur");
		jTableBinding.addColumnBinding(tauxDeChangeBeanProperty_1).setColumnName("Buyer");
		//
		BeanProperty<TauxDeChange, Double> tauxDeChangeBeanProperty_2 = BeanProperty.create("coutVendeur");
		jTableBinding.addColumnBinding(tauxDeChangeBeanProperty_2).setColumnName("Seller");
		//
		ObjectProperty<TauxDeChange> tauxDeChangeObjectProperty = ObjectProperty.create();
		jTableBinding.addColumnBinding(tauxDeChangeObjectProperty).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
