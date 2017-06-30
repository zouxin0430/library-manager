/**
 * 
 */
package zouxin.library.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.EventObject;

import javax.accessibility.AccessibleContext;
import javax.print.PrintService;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.TableUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * @author ZouXin
 * 2017-3-26
 */
public class MyTable extends JTable{

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addNotify() {
		// TODO Auto-generated method stub
		super.addNotify();
	}

	@Override
	protected void configureEnclosingScrollPane() {
		// TODO Auto-generated method stub
		super.configureEnclosingScrollPane();
	}

	@Override
	public void removeNotify() {
		// TODO Auto-generated method stub
		super.removeNotify();
	}

	@Override
	protected void unconfigureEnclosingScrollPane() {
		// TODO Auto-generated method stub
		super.unconfigureEnclosingScrollPane();
	}

	@Override
	public void setTableHeader(JTableHeader tableHeader) {
		// TODO Auto-generated method stub
		super.setTableHeader(tableHeader);
	}

	@Override
	public JTableHeader getTableHeader() {
		// TODO Auto-generated method stub
		return super.getTableHeader();
	}

	@Override
	public void setRowHeight(int rowHeight) {
		// TODO Auto-generated method stub
		super.setRowHeight(rowHeight);
	}

	@Override
	public int getRowHeight() {
		// TODO Auto-generated method stub
		return super.getRowHeight();
	}

	@Override
	public void setRowHeight(int row, int rowHeight) {
		// TODO Auto-generated method stub
		super.setRowHeight(row, rowHeight);
	}

	@Override
	public int getRowHeight(int row) {
		// TODO Auto-generated method stub
		return super.getRowHeight(row);
	}

	@Override
	public void setRowMargin(int rowMargin) {
		// TODO Auto-generated method stub
		super.setRowMargin(rowMargin);
	}

	@Override
	public int getRowMargin() {
		// TODO Auto-generated method stub
		return super.getRowMargin();
	}

	@Override
	public void setIntercellSpacing(Dimension intercellSpacing) {
		// TODO Auto-generated method stub
		super.setIntercellSpacing(intercellSpacing);
	}

	@Override
	public Dimension getIntercellSpacing() {
		// TODO Auto-generated method stub
		return super.getIntercellSpacing();
	}

	@Override
	public void setGridColor(Color gridColor) {
		// TODO Auto-generated method stub
		super.setGridColor(gridColor);
	}

	@Override
	public Color getGridColor() {
		// TODO Auto-generated method stub
		return super.getGridColor();
	}

	@Override
	public void setShowGrid(boolean showGrid) {
		// TODO Auto-generated method stub
		super.setShowGrid(showGrid);
	}

	@Override
	public void setShowHorizontalLines(boolean showHorizontalLines) {
		// TODO Auto-generated method stub
		super.setShowHorizontalLines(showHorizontalLines);
	}

	@Override
	public void setShowVerticalLines(boolean showVerticalLines) {
		// TODO Auto-generated method stub
		super.setShowVerticalLines(showVerticalLines);
	}

	@Override
	public boolean getShowHorizontalLines() {
		// TODO Auto-generated method stub
		return super.getShowHorizontalLines();
	}

	@Override
	public boolean getShowVerticalLines() {
		// TODO Auto-generated method stub
		return super.getShowVerticalLines();
	}

	@Override
	public void setAutoResizeMode(int mode) {
		// TODO Auto-generated method stub
		super.setAutoResizeMode(mode);
	}

	@Override
	public int getAutoResizeMode() {
		// TODO Auto-generated method stub
		return super.getAutoResizeMode();
	}

	@Override
	public void setAutoCreateColumnsFromModel(boolean autoCreateColumnsFromModel) {
		// TODO Auto-generated method stub
		super.setAutoCreateColumnsFromModel(autoCreateColumnsFromModel);
	}

	@Override
	public boolean getAutoCreateColumnsFromModel() {
		// TODO Auto-generated method stub
		return super.getAutoCreateColumnsFromModel();
	}

	@Override
	public void createDefaultColumnsFromModel() {
		// TODO Auto-generated method stub
		super.createDefaultColumnsFromModel();
	}

	@Override
	public void setDefaultRenderer(Class<?> columnClass,
			TableCellRenderer renderer) {
		// TODO Auto-generated method stub
		super.setDefaultRenderer(columnClass, renderer);
	}

	@Override
	public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
		// TODO Auto-generated method stub
		return super.getDefaultRenderer(columnClass);
	}

	@Override
	public void setDefaultEditor(Class<?> columnClass, TableCellEditor editor) {
		// TODO Auto-generated method stub
		super.setDefaultEditor(columnClass, editor);
	}

	@Override
	public TableCellEditor getDefaultEditor(Class<?> columnClass) {
		// TODO Auto-generated method stub
		return super.getDefaultEditor(columnClass);
	}

	@Override
	public void setDragEnabled(boolean b) {
		// TODO Auto-generated method stub
		super.setDragEnabled(b);
	}

	@Override
	public boolean getDragEnabled() {
		// TODO Auto-generated method stub
		return super.getDragEnabled();
	}

	@Override
	public void setAutoCreateRowSorter(boolean autoCreateRowSorter) {
		// TODO Auto-generated method stub
		super.setAutoCreateRowSorter(autoCreateRowSorter);
	}

	@Override
	public boolean getAutoCreateRowSorter() {
		// TODO Auto-generated method stub
		return super.getAutoCreateRowSorter();
	}

	@Override
	public void setUpdateSelectionOnSort(boolean update) {
		// TODO Auto-generated method stub
		super.setUpdateSelectionOnSort(update);
	}

	@Override
	public boolean getUpdateSelectionOnSort() {
		// TODO Auto-generated method stub
		return super.getUpdateSelectionOnSort();
	}

	@Override
	public void setRowSorter(RowSorter<? extends TableModel> sorter) {
		// TODO Auto-generated method stub
		super.setRowSorter(sorter);
	}

	@Override
	public RowSorter<? extends TableModel> getRowSorter() {
		// TODO Auto-generated method stub
		return super.getRowSorter();
	}

	@Override
	public void setSelectionMode(int selectionMode) {
		// TODO Auto-generated method stub
		super.setSelectionMode(selectionMode);
	}

	@Override
	public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
		// TODO Auto-generated method stub
		super.setRowSelectionAllowed(rowSelectionAllowed);
	}

	@Override
	public boolean getRowSelectionAllowed() {
		// TODO Auto-generated method stub
		return super.getRowSelectionAllowed();
	}

	@Override
	public void setColumnSelectionAllowed(boolean columnSelectionAllowed) {
		// TODO Auto-generated method stub
		super.setColumnSelectionAllowed(columnSelectionAllowed);
	}

	@Override
	public boolean getColumnSelectionAllowed() {
		// TODO Auto-generated method stub
		return super.getColumnSelectionAllowed();
	}

	@Override
	public void setCellSelectionEnabled(boolean cellSelectionEnabled) {
		// TODO Auto-generated method stub
		super.setCellSelectionEnabled(cellSelectionEnabled);
	}

	@Override
	public boolean getCellSelectionEnabled() {
		// TODO Auto-generated method stub
		return super.getCellSelectionEnabled();
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		super.selectAll();
	}

	@Override
	public void clearSelection() {
		// TODO Auto-generated method stub
		super.clearSelection();
	}

	@Override
	public void setRowSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		super.setRowSelectionInterval(index0, index1);
	}

	@Override
	public void setColumnSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		super.setColumnSelectionInterval(index0, index1);
	}

	@Override
	public void addRowSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		super.addRowSelectionInterval(index0, index1);
	}

	@Override
	public void addColumnSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		super.addColumnSelectionInterval(index0, index1);
	}

	@Override
	public void removeRowSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		super.removeRowSelectionInterval(index0, index1);
	}

	@Override
	public void removeColumnSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub
		super.removeColumnSelectionInterval(index0, index1);
	}

	@Override
	public int getSelectedRow() {
		// TODO Auto-generated method stub
		return super.getSelectedRow();
	}

	@Override
	public int getSelectedColumn() {
		// TODO Auto-generated method stub
		return super.getSelectedColumn();
	}

	@Override
	public int[] getSelectedRows() {
		// TODO Auto-generated method stub
		return super.getSelectedRows();
	}

	@Override
	public int[] getSelectedColumns() {
		// TODO Auto-generated method stub
		return super.getSelectedColumns();
	}

	@Override
	public int getSelectedRowCount() {
		// TODO Auto-generated method stub
		return super.getSelectedRowCount();
	}

	@Override
	public int getSelectedColumnCount() {
		// TODO Auto-generated method stub
		return super.getSelectedColumnCount();
	}

	@Override
	public boolean isRowSelected(int row) {
		// TODO Auto-generated method stub
		return super.isRowSelected(row);
	}

	@Override
	public boolean isColumnSelected(int column) {
		// TODO Auto-generated method stub
		return super.isColumnSelected(column);
	}

	@Override
	public boolean isCellSelected(int row, int column) {
		// TODO Auto-generated method stub
		return super.isCellSelected(row, column);
	}

	@Override
	public void changeSelection(int rowIndex, int columnIndex, boolean toggle,
			boolean extend) {
		// TODO Auto-generated method stub
		super.changeSelection(rowIndex, columnIndex, toggle, extend);
	}

	@Override
	public Color getSelectionForeground() {
		// TODO Auto-generated method stub
		return super.getSelectionForeground();
	}

	@Override
	public void setSelectionForeground(Color selectionForeground) {
		// TODO Auto-generated method stub
		super.setSelectionForeground(selectionForeground);
	}

	@Override
	public Color getSelectionBackground() {
		// TODO Auto-generated method stub
		return super.getSelectionBackground();
	}

	@Override
	public void setSelectionBackground(Color selectionBackground) {
		// TODO Auto-generated method stub
		super.setSelectionBackground(selectionBackground);
	}

	@Override
	public TableColumn getColumn(Object identifier) {
		// TODO Auto-generated method stub
		return super.getColumn(identifier);
	}

	@Override
	public int convertColumnIndexToModel(int viewColumnIndex) {
		// TODO Auto-generated method stub
		return super.convertColumnIndexToModel(viewColumnIndex);
	}

	@Override
	public int convertColumnIndexToView(int modelColumnIndex) {
		// TODO Auto-generated method stub
		return super.convertColumnIndexToView(modelColumnIndex);
	}

	@Override
	public int convertRowIndexToView(int modelRowIndex) {
		// TODO Auto-generated method stub
		return super.convertRowIndexToView(modelRowIndex);
	}

	@Override
	public int convertRowIndexToModel(int viewRowIndex) {
		// TODO Auto-generated method stub
		return super.convertRowIndexToModel(viewRowIndex);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return super.getRowCount();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return super.getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return super.getColumnName(column);
	}

	@Override
	public Class<?> getColumnClass(int column) {
		// TODO Auto-generated method stub
		return super.getColumnClass(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return super.getValueAt(row, column);
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		// TODO Auto-generated method stub
		super.setValueAt(aValue, row, column);
	}

	@Override
	public void addColumn(TableColumn aColumn) {
		// TODO Auto-generated method stub
		super.addColumn(aColumn);
	}

	@Override
	public void removeColumn(TableColumn aColumn) {
		// TODO Auto-generated method stub
		super.removeColumn(aColumn);
	}

	@Override
	public void moveColumn(int column, int targetColumn) {
		// TODO Auto-generated method stub
		super.moveColumn(column, targetColumn);
	}

	@Override
	public int columnAtPoint(Point point) {
		// TODO Auto-generated method stub
		return super.columnAtPoint(point);
	}

	@Override
	public int rowAtPoint(Point point) {
		// TODO Auto-generated method stub
		return super.rowAtPoint(point);
	}

	@Override
	public Rectangle getCellRect(int row, int column, boolean includeSpacing) {
		// TODO Auto-generated method stub
		return super.getCellRect(row, column, includeSpacing);
	}

	@Override
	public void doLayout() {
		// TODO Auto-generated method stub
		super.doLayout();
	}

	@Override
	public void sizeColumnsToFit(boolean lastColumnOnly) {
		// TODO Auto-generated method stub
		super.sizeColumnsToFit(lastColumnOnly);
	}

	@Override
	public void sizeColumnsToFit(int resizingColumn) {
		// TODO Auto-generated method stub
		super.sizeColumnsToFit(resizingColumn);
	}

	@Override
	public String getToolTipText(MouseEvent event) {
		// TODO Auto-generated method stub
		return super.getToolTipText(event);
	}

	@Override
	public void setSurrendersFocusOnKeystroke(boolean surrendersFocusOnKeystroke) {
		// TODO Auto-generated method stub
		super.setSurrendersFocusOnKeystroke(surrendersFocusOnKeystroke);
	}

	@Override
	public boolean getSurrendersFocusOnKeystroke() {
		// TODO Auto-generated method stub
		return super.getSurrendersFocusOnKeystroke();
	}

	@Override
	public boolean editCellAt(int row, int column) {
		// TODO Auto-generated method stub
		return super.editCellAt(row, column);
	}

	@Override
	public boolean editCellAt(int row, int column, EventObject e) {
		// TODO Auto-generated method stub
		return super.editCellAt(row, column, e);
	}

	@Override
	public boolean isEditing() {
		// TODO Auto-generated method stub
		return super.isEditing();
	}

	@Override
	public Component getEditorComponent() {
		// TODO Auto-generated method stub
		return super.getEditorComponent();
	}

	@Override
	public int getEditingColumn() {
		// TODO Auto-generated method stub
		return super.getEditingColumn();
	}

	@Override
	public int getEditingRow() {
		// TODO Auto-generated method stub
		return super.getEditingRow();
	}

	@Override
	public TableUI getUI() {
		// TODO Auto-generated method stub
		return super.getUI();
	}

	@Override
	public void setUI(TableUI ui) {
		// TODO Auto-generated method stub
		super.setUI(ui);
	}

	@Override
	public void updateUI() {
		// TODO Auto-generated method stub
		super.updateUI();
	}

	@Override
	public String getUIClassID() {
		// TODO Auto-generated method stub
		return super.getUIClassID();
	}

	@Override
	public void setModel(TableModel dataModel) {
		// TODO Auto-generated method stub
		super.setModel(dataModel);
	}

	@Override
	public TableModel getModel() {
		// TODO Auto-generated method stub
		return super.getModel();
	}

	@Override
	public void setColumnModel(TableColumnModel columnModel) {
		// TODO Auto-generated method stub
		super.setColumnModel(columnModel);
	}

	@Override
	public TableColumnModel getColumnModel() {
		// TODO Auto-generated method stub
		return super.getColumnModel();
	}

	@Override
	public void setSelectionModel(ListSelectionModel newModel) {
		// TODO Auto-generated method stub
		super.setSelectionModel(newModel);
	}

	@Override
	public ListSelectionModel getSelectionModel() {
		// TODO Auto-generated method stub
		return super.getSelectionModel();
	}

	@Override
	public void sorterChanged(RowSorterEvent e) {
		// TODO Auto-generated method stub
		super.sorterChanged(e);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		super.tableChanged(e);
	}

	@Override
	public void columnAdded(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		super.columnAdded(e);
	}

	@Override
	public void columnRemoved(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		super.columnRemoved(e);
	}

	@Override
	public void columnMoved(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		super.columnMoved(e);
	}

	@Override
	public void columnMarginChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		super.columnMarginChanged(e);
	}

	@Override
	public void columnSelectionChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		super.columnSelectionChanged(e);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		super.valueChanged(e);
	}

	@Override
	public void editingStopped(ChangeEvent e) {
		// TODO Auto-generated method stub
		super.editingStopped(e);
	}

	@Override
	public void editingCanceled(ChangeEvent e) {
		// TODO Auto-generated method stub
		super.editingCanceled(e);
	}

	@Override
	public void setPreferredScrollableViewportSize(Dimension size) {
		// TODO Auto-generated method stub
		super.setPreferredScrollableViewportSize(size);
	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return super.getPreferredScrollableViewportSize();
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return super.getScrollableUnitIncrement(visibleRect, orientation, direction);
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return super.getScrollableBlockIncrement(visibleRect, orientation, direction);
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return super.getScrollableTracksViewportWidth();
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return super.getScrollableTracksViewportHeight();
	}

	@Override
	public void setFillsViewportHeight(boolean fillsViewportHeight) {
		// TODO Auto-generated method stub
		super.setFillsViewportHeight(fillsViewportHeight);
	}

	@Override
	public boolean getFillsViewportHeight() {
		// TODO Auto-generated method stub
		return super.getFillsViewportHeight();
	}

	@Override
	protected boolean processKeyBinding(KeyStroke ks, KeyEvent e,
			int condition, boolean pressed) {
		// TODO Auto-generated method stub
		return super.processKeyBinding(ks, e, condition, pressed);
	}

	@Override
	protected void createDefaultRenderers() {
		// TODO Auto-generated method stub
		super.createDefaultRenderers();
	}

	@Override
	protected void createDefaultEditors() {
		// TODO Auto-generated method stub
		super.createDefaultEditors();
	}

	@Override
	protected void initializeLocalVars() {
		// TODO Auto-generated method stub
		super.initializeLocalVars();
	}

	@Override
	protected TableModel createDefaultDataModel() {
		// TODO Auto-generated method stub
		return super.createDefaultDataModel();
	}

	@Override
	protected TableColumnModel createDefaultColumnModel() {
		// TODO Auto-generated method stub
		return super.createDefaultColumnModel();
	}

	@Override
	protected ListSelectionModel createDefaultSelectionModel() {
		// TODO Auto-generated method stub
		return super.createDefaultSelectionModel();
	}

	@Override
	protected JTableHeader createDefaultTableHeader() {
		// TODO Auto-generated method stub
		return super.createDefaultTableHeader();
	}

	@Override
	protected void resizeAndRepaint() {
		// TODO Auto-generated method stub
		super.resizeAndRepaint();
	}

	@Override
	public TableCellEditor getCellEditor() {
		// TODO Auto-generated method stub
		return super.getCellEditor();
	}

	@Override
	public void setCellEditor(TableCellEditor anEditor) {
		// TODO Auto-generated method stub
		super.setCellEditor(anEditor);
	}

	@Override
	public void setEditingColumn(int aColumn) {
		// TODO Auto-generated method stub
		super.setEditingColumn(aColumn);
	}

	@Override
	public void setEditingRow(int aRow) {
		// TODO Auto-generated method stub
		super.setEditingRow(aRow);
	}

	@Override
	public TableCellRenderer getCellRenderer(int row, int column) {
		// TODO Auto-generated method stub
		return super.getCellRenderer(row, column);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row,
			int column) {
		// TODO Auto-generated method stubif (c instanceof JComponent) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (c instanceof JComponent) {
		     ((JComponent) c).setOpaque(false);
		    }
		    return c;
//		return super.prepareRenderer(renderer, row, column);
	}

	@Override
	public TableCellEditor getCellEditor(int row, int column) {
		// TODO Auto-generated method stub
		return super.getCellEditor(row, column);
	}

	@Override
	public Component prepareEditor(TableCellEditor editor, int row, int column) {
		// TODO Auto-generated method stub
		return super.prepareEditor(editor, row, column);
	}

	@Override
	public void removeEditor() {
		// TODO Auto-generated method stub
		super.removeEditor();
	}

	@Override
	protected String paramString() {
		// TODO Auto-generated method stub
		return super.paramString();
	}

	@Override
	public boolean print() throws PrinterException {
		// TODO Auto-generated method stub
		return super.print();
	}

	@Override
	public boolean print(PrintMode printMode) throws PrinterException {
		// TODO Auto-generated method stub
		return super.print(printMode);
	}

	@Override
	public boolean print(PrintMode printMode, MessageFormat headerFormat,
			MessageFormat footerFormat) throws PrinterException {
		// TODO Auto-generated method stub
		return super.print(printMode, headerFormat, footerFormat);
	}

	@Override
	public boolean print(PrintMode printMode, MessageFormat headerFormat,
			MessageFormat footerFormat, boolean showPrintDialog,
			PrintRequestAttributeSet attr, boolean interactive)
			throws PrinterException, HeadlessException {
		// TODO Auto-generated method stub
		return super.print(printMode, headerFormat, footerFormat, showPrintDialog,
				attr, interactive);
	}

	@Override
	public boolean print(PrintMode printMode, MessageFormat headerFormat,
			MessageFormat footerFormat, boolean showPrintDialog,
			PrintRequestAttributeSet attr, boolean interactive,
			PrintService service) throws PrinterException, HeadlessException {
		// TODO Auto-generated method stub
		return super.print(printMode, headerFormat, footerFormat, showPrintDialog,
				attr, interactive, service);
	}

	@Override
	public Printable getPrintable(PrintMode printMode,
			MessageFormat headerFormat, MessageFormat footerFormat) {
		// TODO Auto-generated method stub
		return super.getPrintable(printMode, headerFormat, footerFormat);
	}

	@Override
	public AccessibleContext getAccessibleContext() {
		// TODO Auto-generated method stub
		return super.getAccessibleContext();
	}
    

}
