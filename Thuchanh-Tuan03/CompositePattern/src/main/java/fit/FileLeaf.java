/*
 * @ (#) FileLeaf.java    1.0    21/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 21/03/2025
 * @version: 1.0
 */

public class FileLeaf implements FileComponent {
    private String name;
    private long size;

    public FileLeaf(String name, long size) {
        super();
        this.name = name;
        this.size = size;
    }

    @Override
    public long totalSize() {
        return size;
    }

    @Override
    public void showProperty() {
        System.out.println("FileLeaf [name=" + name + ", size=" + size + "]");
    }
}
