package lv.merrill.app.couchdb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.entity.AbstractHttpEntity;

class JsonbHttpEntity extends AbstractHttpEntity {
	

	@Override
	public boolean isRepeatable() {
		return true;
	}

	@Override
	public long getContentLength() {
		return 0;
	}

	@Override
	public InputStream getContent() throws IOException, UnsupportedOperationException {
		return null;
	}

	@Override
	public void writeTo(OutputStream outstream) throws IOException {

	}

	@Override
	public boolean isStreaming() {
		return false;
	}
}
