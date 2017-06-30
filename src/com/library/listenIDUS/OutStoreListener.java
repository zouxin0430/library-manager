/**
 * 
 */
package com.library.listenIDUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.Outstore;

/**
 * @author ZouXin
 *2017-5-16
 */
public class OutStoreListener implements ActionListener{
     Outstore outstore;
     public OutStoreListener(Outstore outstore){
    	 this.outstore=outstore;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		MainViewDao dao=new MainViewDao();
		if(command.equals("确定")){
			int select=JOptionPane.showConfirmDialog(outstore, "是否出库书籍");
			if (select==0){
				String book=outstore.getTextField_1().getText().split("_")[1];
				String location=outstore.getComboBox().getSelectedItem().toString().split("_")[1];
				String quantity=outstore.getTextField().getText();
				int s=dao.updateSurplusQuantity1(book, location, Integer.parseInt(quantity), 0);
				if(s==1){
					JOptionPane.showMessageDialog(outstore, "书籍出库成功");
					outstore.setVisible(false);
					outstore.dispose();
				}else{
					JOptionPane.showMessageDialog(outstore, "系统错误");
				}
			}
			
		}else if(command.equals("取消")){
			int select=JOptionPane.showConfirmDialog(outstore, "是否出库书籍");
			if (select==0){
				outstore.setVisible(false);
				outstore.dispose();
			}
		}else if(command.equals("查询")){
			
		}
	}
    
}
