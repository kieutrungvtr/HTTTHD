using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Ds.Bussiness.Startup))]
namespace Ds.Bussiness
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
