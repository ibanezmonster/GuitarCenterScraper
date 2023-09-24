package com.gc.scripting;

//import java.io.InputStream;
//import java.io.OutputStream;
//
//class SyncPipe implements Runnable
//{
//public SyncPipe(InputStream istrm, OutputStream ostrm) {
//      istrm_ = istrm;
//      ostrm_ = ostrm;
//  }
//  public void run() {
//      try
//      {
//          final byte[] buffer = new byte[1024];
//          for (int length = 0; (length = istrm_.read(buffer)) != -1; )
//          {
//              ostrm_.write(buffer, 0, length);
//          }
//      }
//      catch (Exception e)
//      {
//          e.printStackTrace();
//      }
//  }
//  private final OutputStream ostrm_;
//  private final InputStream istrm_;
//}



//optional code to switch to cmd output in console
//new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
//new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
						

//
//OutputStream out = proc.getOutputStream();
//new Thread(() -> {
//    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
//        bw.write("[command here]");
//        bw.flush();
//    } catch (IOException ioe) {
//        ioe.printStackTrace();
//    }
//
//}).start();
//
//
//stdin.println("python -m gc_run");
//stdin.close();
//p.waitFor();


