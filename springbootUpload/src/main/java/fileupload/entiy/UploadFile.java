package fileupload.entiy;

import java.io.File;
import java.util.Arrays;

public class UploadFile {
    private String fileName;
    private String originalFilename;
    private Long size;
    private String contentType;
    private byte[] bytes;
    private File file;

    public UploadFile() {
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Long getSize() {
        return this.size;
    }

    public String getContentType() {
        return this.contentType;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public File getFile() {
        return this.file;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public void setOriginalFilename(final String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    public void setBytes(final byte[] bytes) {
        this.bytes = bytes;
    }

    public void setFile(final File file) {
        this.file = file;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UploadFile)) {
            return false;
        } else {
            UploadFile other = (UploadFile)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label75: {
                    Object this$fileName = this.getFileName();
                    Object other$fileName = other.getFileName();
                    if (this$fileName == null) {
                        if (other$fileName == null) {
                            break label75;
                        }
                    } else if (this$fileName.equals(other$fileName)) {
                        break label75;
                    }

                    return false;
                }

                Object this$originalFilename = this.getOriginalFilename();
                Object other$originalFilename = other.getOriginalFilename();
                if (this$originalFilename == null) {
                    if (other$originalFilename != null) {
                        return false;
                    }
                } else if (!this$originalFilename.equals(other$originalFilename)) {
                    return false;
                }

                Object this$size = this.getSize();
                Object other$size = other.getSize();
                if (this$size == null) {
                    if (other$size != null) {
                        return false;
                    }
                } else if (!this$size.equals(other$size)) {
                    return false;
                }

                label54: {
                    Object this$contentType = this.getContentType();
                    Object other$contentType = other.getContentType();
                    if (this$contentType == null) {
                        if (other$contentType == null) {
                            break label54;
                        }
                    } else if (this$contentType.equals(other$contentType)) {
                        break label54;
                    }

                    return false;
                }

                if (!Arrays.equals(this.getBytes(), other.getBytes())) {
                    return false;
                } else {
                    Object this$file = this.getFile();
                    Object other$file = other.getFile();
                    if (this$file == null) {
                        if (other$file != null) {
                            return false;
                        }
                    } else if (!this$file.equals(other$file)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UploadFile;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $fileName = this.getFileName();
//        int result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
//        Object $originalFilename = this.getOriginalFilename();
//        result = result * 59 + ($originalFilename == null ? 43 : $originalFilename.hashCode());
//        Object $size = this.getSize();
//        result = result * 59 + ($size == null ? 43 : $size.hashCode());
//        Object $contentType = this.getContentType();
//        result = result * 59 + ($contentType == null ? 43 : $contentType.hashCode());
//        result = result * 59 + Arrays.hashCode(this.getBytes());
//        Object $file = this.getFile();
//        result = result * 59 + ($file == null ? 43 : $file.hashCode());
//        return result;
//    }

    public String toString() {
        return "UploadFile(fileName=" + this.getFileName() + ", originalFilename=" + this.getOriginalFilename() + ", size=" + this.getSize() + ", contentType=" + this.getContentType() + ", bytes=" + Arrays.toString(this.getBytes()) + ", file=" + this.getFile() + ")";
    }
}

