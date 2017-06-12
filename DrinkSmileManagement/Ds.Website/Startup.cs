using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Ds.Website.Startup))]
namespace Ds.Website
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
