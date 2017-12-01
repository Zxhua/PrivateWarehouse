package demo.zxhua.daggerdemo.core.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static demo.zxhua.daggerdemo.core.api.Status.ERROR;
import static demo.zxhua.daggerdemo.core.api.Status.LOADING;
import static demo.zxhua.daggerdemo.core.api.Status.SUCCESS;

/**
 * Created by Zxhua on 2017/11/25 0025.
 */

public class Resource<T> {
    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;

    public Resource(@NonNull Status status, @Nullable String message, @Nullable T data) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCESS, null, data);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, msg, data);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, null, data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Resource<?> resource = (Resource<?>) obj;

        if (status != resource.status) {
            return false;
        }

        if (message != null ? !message.equals(resource.message) : resource.message != null) {
            return false;
        }
        return data != null ? data.equals(resource.data) : resource.data == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "status = " + status +
                ",message = " + message + '\'' +
                ",data = " + data +
                "}";
    }
}
