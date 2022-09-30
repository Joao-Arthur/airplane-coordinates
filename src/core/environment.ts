
function isDev() {
    return true;
}

function isProd() {
    return false;
}

export const environment = {
    isDev,
    isProd,
} as const;
