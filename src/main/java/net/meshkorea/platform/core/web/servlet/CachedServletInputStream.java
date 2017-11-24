package net.meshkorea.platform.core.web.servlet;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * An inputStream which reads the cached request body
 */
public class CachedServletInputStream extends ServletInputStream {

    private ByteArrayInputStream input;

    public CachedServletInputStream(byte[] contents) {
        // create a new input stream from the cached request body
        this.input = new ByteArrayInputStream(contents);
    }

    @Override
    public int read() throws IOException {
        return this.input.read();
    }

    @Override
    public boolean isFinished() {
        return input.available() == 0;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener listener) {
        throw new RuntimeException("Not implemented");
    }

}