package club.codedemo.springsecurityexpressions;

import org.springframework.security.core.Authentication;

import java.io.Serializable;

public class CustomPermissionEvaluator implements org.springframework.security.access.PermissionEvaluator {
    /**
     * 方法将在PreAuthorize中使用hasPermission调用
     * 比如： @PreAuthorize("hasPermission(#token, 'isCorrect')")
     *
     * @param authentication     认证信息
     * @param targetDomainObject 传入的参数值。 上例中为 token的值
     * @param permission         认证的方法名。上例中为 isCorrect
     * @return 通过返回true, 不通过返回false
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if ((authentication == null) || (targetDomainObject == null) || !(permission instanceof String)) {
            return false;
        }

        return "isCorrect".equals(permission) && "1234".equals(targetDomainObject);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        if ((authentication == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        return true;
    }
}
