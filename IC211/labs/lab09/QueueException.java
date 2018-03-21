/**
A new exception called QueueException which is thrown from the Queue Class
@author Thompson, Joshua - 206360
*/
public class QueueException extends RuntimeException
{
  /**
  Long datafield that is required from some unknown reason
  */
  private static final long serialVersionUID = 0L;

  /**
  Constructor for the exception that takes a message parameter
  @param msg String message
  */
  public QueueException(String msg)
  {
    super(msg);
  }

}
