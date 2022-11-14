type methodType = 'GET' | 'POST' | 'PATCH' | 'DELETE';

const baseURL = 'http://localhost:8080';

function customFetch<T>(
    method: methodType,
    resource: string,
    content?: unknown,
): Promise<T> {
    return fetch(`${baseURL}/${resource}`, {
        method,
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json',
        },
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(content),
    }).then(res => {
        if (!res.ok)
            throw new Error(res.statusText);
        return res.json();
    });
}

export function postFetch<T>(resource: string, content?: unknown) {
    return customFetch<T>('POST', resource, content);
}
