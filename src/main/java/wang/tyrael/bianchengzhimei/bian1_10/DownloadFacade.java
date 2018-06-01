package wang.tyrael.bianchengzhimei.bian1_10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 其实可以直接用阻塞队列
 * 这相当于阻塞队列的实现
 * @author: wangchao
 * 2018/6/1 0001
 */
public class DownloadFacade {
    public static final int BUFFER_SIZE = 3;
    byte[] mockBuffer;
    Semaphore semaphoreSpace = new Semaphore(BUFFER_SIZE);
    Semaphore semaphoreData = new Semaphore(0);
    int inIndex = 0;
    int outIndex = 0;
    volatile  boolean flagDoneDownload = false;
    boolean flagDoneWrite = false;

    List<Byte> mockFile = new ArrayList<>();
    List<Byte> mockNet = new ArrayList<>();

    void init(){
        mockBuffer = new byte[BUFFER_SIZE];
    }

    boolean getBlockFromNet(byte[] buffer, int index){
        Byte block = mockNet.remove(0);
        if (block == null){
            return false;
        }else{
            buffer[index] = block;
            return true;
        }
    }

    void writeBlockToDisk(byte[] buffer, int index){
        mockFile.add(buffer[index]);
    }

    //******执行框架
    public void run(){
        init();
        new Thread(()-> {
                try {
                    runGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        new Thread(()->{
            try {
                runWrite();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    void runGet() throws InterruptedException {
        while (!flagDoneDownload){
            semaphoreSpace.acquire();
            flagDoneDownload = getBlockFromNet(mockBuffer, inIndex);
            inIndex = (inIndex+1)%BUFFER_SIZE;
            semaphoreData.release();
        }
    }

    void runWrite() throws InterruptedException {
        while (!flagDoneWrite){
            semaphoreData.acquire();;
            writeBlockToDisk(mockBuffer, outIndex);
            outIndex = (inIndex +1)% BUFFER_SIZE;
            semaphoreSpace.release();
            if (flagDoneDownload && outIndex == inIndex){
                flagDoneWrite = true;
            }
        }
    }
}
