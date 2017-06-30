/**
 * 
 */
package com.library.listenIDUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.Instore;

/**
 * @author ZouXin
 *2017-5-16
 */
public class InStoreListener implements ActionListener{
    Instore instore;
    public InStoreListener(Instore instore){
    	this.instore=instore;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		MainViewDao dao=new MainViewDao();
		if(command.equals("确定")){
			int select=JOptionPane.showConfirmDialog(instore, "是否确定入库");
			if(select==0){
				String quantity=instore.getTextField().getText();
//				String library=instore.getComboBox().getSelectedItem().toString().split("_")[1];
//				String room=instore.getComboBox_1().getSelectedItem().toString().split("_")[1];
				String location=instore.getComboBox_2().getSelectedItem().toString().split("_")[1];
				String book=instore.getTextField_1().getText().split("_")[1];
				int s=dao.updateSurplusQuantity(book, location, Integer.parseInt(quantity), 0);
				if(s==1){
					JOptionPane.showMessageDialog(instore, "入库成功");
					instore.setVisible(false);
					instore.dispose();
				}else{
					JOptionPane.showMessageDialog(instore, "系统错误");
				}
			}		
		}else if(command.equals("取消")){
			int select=JOptionPane.showConfirmDialog(instore, "是否确定取消");
			if(select==0){
				instore.setVisible(false);
				instore.dispose();
			}
		}else if(command.equals("查询")){
			
		}
	}
   
}
