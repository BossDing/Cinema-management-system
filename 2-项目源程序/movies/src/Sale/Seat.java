package Sale;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Seat extends JLabel{
	private int isPitchOn;
	private int seatNumber;
	public Seat(int x){
		isPitchOn=x;
		if(isPitchOn==0){
			this.setIcon(new ImageIcon("src/img/1.png"));
		}else{
			this.setIcon(new ImageIcon("src/img/2.png"));
		}
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ImageIcon image = new ImageIcon("src/img/2.png");
				JLabel JL=(JLabel) e.getSource();
				if(e.getButton()==e.BUTTON1){//µã»÷Êó±ê×ó¼ü  
					if(isPitchOn==0){
						image = new ImageIcon("src/img/2.png");
						isPitchOn=1;
					}
					else if(isPitchOn==1){
						image = new ImageIcon("src/img/1.png");
						isPitchOn=0;
					}
				}
				image.setImage(image.getImage().getScaledInstance(JL.getWidth(),JL.getHeight(), Image.SCALE_DEFAULT));
				JL.setIcon(image);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
	public void adaptive(){
		ImageIcon image = (ImageIcon) this.getIcon();
		image.setImage(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_DEFAULT));
		this.setIcon(image);
	}
	public void setisPitchOn(int x){
		this.isPitchOn=x;
	}
	public int getisPitchOn(){
		return isPitchOn;
	}
}
