/*
 * @ (#) Observer.java    1.0    15/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 15/03/2025
 * @version: 1.0
 */

public interface Observer {
    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject sub);
}
