package musicOrganiserSQL;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.DefaultRowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmMusicOrganiser;
	private JTextField txtArtist;
	private JTextField txtAlbum;
	private JTextField txtTrack;
	private JTextField txtGenre;
	private JTextField txtFormat;
	private JTable Display_Music;
	private JTextField txtId;

	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frmMusicOrganiser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame() {
		initialize();
		Show_Music_In_JTable();
	}
	
	
	
	
	
	
	
	
	public Connection getConnection()
	   {
	       Connection con;
	       try {
	    	   Class.forName("com.mysql.jdbc.Driver");
	           con = DriverManager.getConnection("jdbc:mysql://localhost/ab00631_music", "root","");
	           return con;
	       } catch (Exception e) {
	           e.printStackTrace();
	           return null;
	       }
	   }
	        

	
	
	
	
	
	
	
	
	
	   public ArrayList<Music> getMusicList()
	   {
	       ArrayList<Music> musicList = new ArrayList<Music>();
	       Connection connection = getConnection();
	       
	       String query = "SELECT * FROM  `music` ";
	       Statement st;
	       ResultSet rs;
	       
	       try {
	           st = connection.createStatement();
	           rs = st.executeQuery(query);
	           Music music;
	           while(rs.next())
	           {
	               music = new Music(rs.getInt("id"),rs.getString("artist"),rs.getString("track"),rs.getString("album"),rs.getString("genre"),rs.getString("format"));
	               musicList.add(music);
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return musicList;
	   }
	  
	   
	   
	   
	   
	   
	   
	   
	   
	   public void Show_Music_In_JTable()
	   {
	       ArrayList<Music> list = getMusicList();
	       DefaultTableModel model = (DefaultTableModel)Display_Music.getModel();
	       Object[] row = new Object[6];
	       for(int i = 0; i < list.size(); i++)
	       {
	           row[0] = list.get(i).getId();
	           row[1] = list.get(i).getArtist();
	           row[2] = list.get(i).getTrack();
	           row[3] = list.get(i).getAlbum();
	           row[4] = list.get(i).getGenre();
	           row[5] = list.get(i).getFormat();
	           
	           model.addRow(row);
	       }
	    }
	        
	   
	   
	   
	   
	   
	   
	   
	   
	   public void executeSQlQuery(String query, String message)
	   {
	       Connection con = getConnection();
	       Statement st;
	       try{
	           st = con.createStatement();
	           if((st.executeUpdate(query)) == 1)
	           {
	               DefaultTableModel model = (DefaultTableModel)Display_Music.getModel();
	               model.setRowCount(0);
	               Show_Music_In_JTable();
	            }
	       }catch(Exception ex){
	       		ex.printStackTrace();
	       }
	   }
	 
	   
	   
	   
	   
	   
	   
	   
	public void initialize() {
		frmMusicOrganiser = new JFrame();
		frmMusicOrganiser.setResizable(false);
		frmMusicOrganiser.setTitle("Music Organiser");
		frmMusicOrganiser.setBounds(100, 100, 580, 480);
		frmMusicOrganiser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicOrganiser.getContentPane().setLayout(null);
		
		
		
		
		
		
		JLabel lblArist = new JLabel("Artist");
		lblArist.setBounds(88, 20, 61, 16);
		frmMusicOrganiser.getContentPane().add(lblArist);
		
		JLabel lblTrack = new JLabel("Track");
		lblTrack.setBounds(304, 20, 61, 16);
		frmMusicOrganiser.getContentPane().add(lblTrack);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(88, 48, 61, 16);
		frmMusicOrganiser.getContentPane().add(lblAlbum);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(304, 48, 61, 16);
		frmMusicOrganiser.getContentPane().add(lblGenre);
		
		JLabel lblFormat = new JLabel("Format");
		lblFormat.setBounds(88, 75, 61, 16);
		frmMusicOrganiser.getContentPane().add(lblFormat);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(322, 75, 14, 16);
		frmMusicOrganiser.getContentPane().add(lblId);
		
		
		
		
		
		
		txtArtist = new JTextField();
		txtArtist.setColumns(10);
		txtArtist.setBounds(127, 20, 150, 16);
		frmMusicOrganiser.getContentPane().add(txtArtist);
		
		txtTrack = new JTextField();
		txtTrack.setColumns(10);
		txtTrack.setBounds(341, 20, 150, 16);
		frmMusicOrganiser.getContentPane().add(txtTrack);
		
		txtAlbum = new JTextField();
		txtAlbum.setColumns(10);
		txtAlbum.setBounds(132, 48, 145, 16);
		frmMusicOrganiser.getContentPane().add(txtAlbum);
		
		txtGenre = new JTextField();
		txtGenre.setColumns(10);
		txtGenre.setBounds(341, 48, 150, 16);
		frmMusicOrganiser.getContentPane().add(txtGenre);
		
		txtFormat = new JTextField();
		txtFormat.setColumns(10);
		txtFormat.setBounds(135, 75, 142, 16);
		frmMusicOrganiser.getContentPane().add(txtFormat);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setEditable(false);
		txtId.setBounds(341, 75, 48, 16);
		frmMusicOrganiser.getContentPane().add(txtId);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 118, 568, 285);
		frmMusicOrganiser.getContentPane().add(scrollPane);
		
		
		
		Display_Music = new JTable();
		Display_Music.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "DB_ID", "Artist", "Track", "Album", "Genre", "Format"
	            }
	        ));
		Display_Music.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                Display_MusicMouseClicked(evt);
	            }
	        });
		scrollPane.setViewportView(Display_Music);
		Display_Music.getTableHeader().setReorderingAllowed(false);
		Display_Music.setAutoCreateRowSorter(true);
		DefaultRowSorter<?, ?> sorter = ((DefaultRowSorter<?, ?>)Display_Music.getRowSorter());
		ArrayList<SortKey> list = new ArrayList<SortKey>();
		list.add(new RowSorter.SortKey(1, SortOrder.ASCENDING) );
		sorter.setSortKeys(list);
		sorter.sort();
		
	    
	    
	    
	    
	    
	    
	    
	    
	    JButton btnImport = new JButton("Import");
	    btnImport.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	btnImportActionPerformed(evt);
	            }
	        });
		btnImport.setBounds(385, 70, 112, 29);
		frmMusicOrganiser.getContentPane().add(btnImport);
		
		
		
		
		
		
		
		
		JButton btnDeleteSelectedRow = new JButton("Delete Selected Row");
		btnDeleteSelectedRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnDeleteSelectedRowActionPerformed(evt);
            }
        });
		btnDeleteSelectedRow.setBounds(205, 415, 170, 29);
		frmMusicOrganiser.getContentPane().add(btnDeleteSelectedRow);
		
		
	}


	private void Display_MusicMouseClicked(MouseEvent evt) {
		
		int i = Display_Music.getSelectedRow();

        TableModel model = Display_Music.getModel();
        
        txtId.setText(model.getValueAt(i,0).toString());
        
        txtArtist.setText(model.getValueAt(i,1).toString());

        txtTrack.setText(model.getValueAt(i,2).toString());

        txtAlbum.setText(model.getValueAt(i,3).toString());

        txtGenre.setText(model.getValueAt(i,4).toString());
        
        txtFormat.setText(model.getValueAt(i,5).toString());
		
	}
	

	private void btnImportActionPerformed(ActionEvent evt) {
		
		String query = "INSERT INTO `music`(`artist`, `track`, `album`, `genre`, `format`) VALUES ('"+txtArtist.getText()+"','"+txtTrack.getText()+"','"+txtAlbum.getText()+"','"+txtGenre.getText()+"','"+txtFormat.getText()+"')";
        
        executeSQlQuery(query, "Inserted");
	}
	

	private void btnDeleteSelectedRowActionPerformed(ActionEvent evt) {
		
		String query = "DELETE FROM `music` WHERE id = "+txtId.getText();
		
        executeSQlQuery(query, "Deleted");
	}
	
}
