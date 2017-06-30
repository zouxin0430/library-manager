package zouxin.library.Listen;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import zouxin.library.dao.MainViewDao;
import zouxin.library.view.MainView;

public class CardSwitchListenner implements ActionListener{
    MainView mainView;
    public CardSwitchListenner(MainView mainView){
    	this.mainView=mainView;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		CardLayout layout=new CardLayout();
		String command=e.getActionCommand();
		System.out.println(mainView.getTextField().getText());
		if(command.equals("借阅书籍")){
			mainView.getCard().show(mainView.getPanel_Card(), "Preemption");
		}else if(command.equals("所借书籍")){
			mainView.getCard().show(mainView.getPanel_Card(), "BackBook");
			MainViewDao dao=new MainViewDao();
	    	Object[][] ob=dao.getBorrow();
	    	Object[] cloumnNames=new Object[]{"书籍名称","数量","借书时间","归还时间","图书馆","库室","库位","书籍编号","编号","库位编号"};
//	    	Object[] cloumnNames=new Object[]{"图书馆","库室","库位","书名","剩余数量","书籍类型","作者","单价","条形码","出版社","书籍编号"};//列名
	    	DefaultTableModel model=new DefaultTableModel(ob,cloumnNames);
	    	mainView.getTable_3().setModel(model);
		}else if(command.equals("共享书籍")){
			mainView.getCard().show(mainView.getPanel_Card(), "shared");
		}else if(command.equals("修改密码")){
			mainView.getCard().show(mainView.getPanel_Card(), "Update");
		}
		
	}

}
