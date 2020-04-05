public class History {
  private static HistoryElement[] history = new HistoryElement[1];

  public static void addHistory(HistoryElement elem) {
    HistoryElement[] nArray = new HistoryElement[history.length + 1];
    for (int i = 0; i < history.length; i++)
      nArray[i] = history[i];

    nArray[nArray.length - 1] = elem;
    history = nArray;

  }

  public static HistoryElement[] getHistory() {

    return history;
  }
}