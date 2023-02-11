export default function guard(to, from, next) {
    if (to.path == '/logout') {
        localStorage.clear();
        next('/login');
        return;
    }
    let requiredRoles = [];
    for (const meta of to.matched.map(v => v.meta)) {
        if (meta.roles != null) {
            (meta.roles).forEach(r => requiredRoles.push(r));
        } else if (meta.role != null) {
            requiredRoles.push(meta.role);
        }
    }
    if (requiredRoles.length == 0) {
        next()
    } else {
        if (localStorage.getItem("username") && localStorage.getItem("password")) {
            const accepted = requiredRoles.some(r => localStorage.getItem('role') == r)
            if (!accepted) {
                next("/403");
            } else {
                next()
            }
        } else {
            next("/login");
        }
    }
}