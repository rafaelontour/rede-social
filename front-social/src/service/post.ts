
const urlBackend = process.env.NEXT_PUBLIC_BACKEND_URL

async function buscarPostService() {
    try {
        const response = await fetch("http://localhost:8080/graphql", {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                query: `
                    query {
                        getPostById(id: "68fd157267f3a077d7e0c575") {
                            id
                            authorId
                            content
                            mediaUrls
                            likesCount
                            createdAt
                            comments
                        }
                    }
                `
            })
        });

        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status} - ${response.statusText}`);
        }

        const data = await response.json();

        // Erro interno do GraphQL
        if (data.errors) {
            console.error("Erro GraphQL:", data.errors);
            throw new Error(data.errors[0].message);
        }

        return data.data.getPostById; // retorna só o post

    } catch (error) {
        console.error("Erro ao buscar post:", error);
        throw error; // mantém o erro para o chamador tratar
    }
}


async function buscarPosts2() {
    // logica
}

async function buscarPosts3() {
    // logica
}

async function buscarPosts4() {
    // logica
}

async function buscarPosts5() {
    // logica
}

export {
    buscarPostService
}