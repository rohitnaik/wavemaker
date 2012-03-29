
package com.wavemaker.tools.io;

import com.wavemaker.tools.io.exception.ResourceExistsException;

/**
 * A file {@link Resource} that may be stored on a physical disk or using some other mechanism.
 * 
 * @see Folder
 * @see MutableFile
 * 
 * @author Phillip Webb
 */
public interface File extends Resource {

    @Override
    File moveTo(Folder folder);

    @Override
    File copyTo(Folder folder);

    @Override
    File rename(String name) throws ResourceExistsException;

    /**
     * Returns the size in bytes of the virtual file.
     * 
     * @return the size in bytes
     */
    long getSize();

    /**
     * Gets the time this file object was last modified. The time is measured in milliseconds since the epoch (00:00:00
     * GMT, January 1, 1970).
     * 
     * @return the time this file object was last modified; or 0 if the file object does not exist, if an I/O error
     *         occurred, or if the operation is not supported
     */
    long getLastModified();

    /**
     * Provides access to file content. Calling any method on a file that does not {@link #exists() exist} will cause it
     * to be created.
     * 
     * @return the file content
     */
    FileContent getContent();
}