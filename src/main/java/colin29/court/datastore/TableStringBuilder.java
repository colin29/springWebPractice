package colin29.court.datastore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Used to print a table of values in a justified table. Values which are too long will be truncated. Each printer
 * should be used for formatting a single table.
 * 
 * @author Colin Ta
 *
 */
public class TableStringBuilder {

	public int columnWidth = 14;
	private int maxContentsWidth = columnWidth - 2;

	private List<String> columnTitles = new ArrayList<String>();

	private String rowsStr = ""; // the accumulated table stirng

	public void addColumnsTitles(String... columnTitles) {
		// LoggerFactory.getLogger(this.getClass()).debug(String.valueOf(columnTitle.length));
		this.columnTitles.addAll(Arrays.asList(columnTitles));
	}

	public void addRow(String... rowValues) {
		String formattedCell;

		for (String value : rowValues) {
			if (value == null)
				value = "null";
			formattedCell = StringUtils.rightPad(StringUtils.abbreviate(value, maxContentsWidth),
					columnWidth);
			this.rowsStr += formattedCell;
		}
		this.rowsStr += "\n";
	}

	private String getTitleRowString() {
		String str = "";
		for (int i = 0; i < columnTitles.size(); i++) {
			String columnTitle = columnTitles.get(i);
			columnTitle = StringUtils.rightPad(StringUtils.abbreviate(columnTitle, maxContentsWidth), columnWidth);
			str += columnTitle;
		}
		str += "\n";
		return str;
	}

	public String getTableString() {
		return getTitleRowString() + rowsStr;
	}

	// private void print(ResultSet resultSet) throws SQLException {
	// ResultSetMetaData rsmd = resultSet.getMetaData();
	// int columnsNumber = columnTitles.size();
	//
	// String str = "";
	//
	// for (int i = 1; i <= columnsNumber; i++) {
	// String columnTitle = rsmd.getColumnName(i);
	// columnTitle = StringUtils.rightPad(StringUtils.abbreviate(columnTitle, maxContentsWidth), columnWidth);
	// str += columnTitle;
	// }
	// str += "\n";
	//
	// while (resultSet.next()) {
	// for (int i = 1; i <= columnsNumber; i++) {
	// String cellContents = resultSet.getString(i);
	// if (cellContents == null)
	// cellContents = "null";
	// cellContents = StringUtils.rightPad(StringUtils.abbreviate(cellContents, maxContentsWidth),
	// columnWidth);
	//
	// str += cellContents;
	// }
	// str += "\n";
	// }
	// System.out.println(str);
	// }

}
